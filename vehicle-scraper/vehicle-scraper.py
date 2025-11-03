import requests
from bs4 import BeautifulSoup
from typing import Dict, Any, List
import time
import re


from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


BASE_URL = "https://wiki.warthunder.com"
GROUND_PREFIX = "/ground?v=l"
AIR_PREFIX="/air?v=l"

HEADERS = {
    "Content-Type": "application/json",     # Tell server we're sending JSON
    "Accept": "application/json"            # Optional: expect JSON back
}



def put_vehicle(URL: str , data: Dict[str, Any]) -> None:
    try:
        response = requests.put(
            url=URL,
            headers=HEADERS,
            json=data,          # <-- automatically serializes dict to JSON
            timeout=10
        )
    except requests.exceptions.HTTPError as http_err:
        print(f"HTTP error occurred: {http_err}")
        print("Response body:", response.text)
    except requests.exceptions.ConnectionError:
        print("Failed to connect to the server. Check URL/host.")
    except requests.exceptions.Timeout:
        print("Request timed out.")
    except requests.exceptions.RequestException as err:
        print(f"Other error: {err}")

def post_vehicle_batch(URL: str , data: List[Dict]) -> None:

    print("Putting Batch!")

    try:
        print(data)
        response = requests.post(
            url=URL,
            headers=HEADERS,
            json={"data": data},          # <-- automatically serializes dict to JSON
            timeout=10
        )
    except requests.exceptions.HTTPError as http_err:
        print(f"HTTP error occurred: {http_err}")
        print("Response body:", response.text)
    except requests.exceptions.ConnectionError:
        print("Failed to connect to the server. Check URL/host.")
    except requests.exceptions.Timeout:
        print("Request timed out.")
    except requests.exceptions.RequestException as err:
        print(f"Other error: {err}")


driver = webdriver.Chrome()
driver.get(BASE_URL + GROUND_PREFIX)
wait = WebDriverWait(driver, 10)
wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, ".wt-ulist_instance > tbody > tr")))
# soup = None

# for attempt in range(5):                     # try up to 5 times
# response = requests.get(baseurl + ground_suffix)
soup = BeautifulSoup(driver.page_source, 'html.parser')

vehicle_rows = soup.select('.wt-ulist_instance > tbody > tr')

# for element in all_row_element:
    # print(element.get("data-ulist-id"))

batch = []

JAVA_API_URL = "http://localhost:8080/api/v1/vehicle/batch"

for specific_vehicle_element in vehicle_rows:
    if len(batch) >= 50:
        post_vehicle_batch(JAVA_API_URL, batch)
        batch.clear()
        time.sleep(3)
    print(specific_vehicle_element)
    
    unit_id = specific_vehicle_element.get_attribute_list("data-ulist-id")[0]
    unit_name = specific_vehicle_element.find("span").getText()
    unit_country = specific_vehicle_element.find(class_="wt-ulist_unit-country").get_attribute_list("data-value")[0]


    # print(unit_id)
    # print(unit_name)
    # print(unit_country)
    
    # unit_rank = specific_vehicle_element.find(attrs="data-value")
    #wt-unit-list > div > table > tbody > tr:nth-child(1) > td:nth-child(4)


    # specific_tank_response = requests.get(baseurl + unit_specific_suffix)
    # specific_tank_soup = BeautifulSoup(specific_tank_response.text, 'html.parser')
    # unit_name = specific_tank_soup.find_all(class_="game-unit_name")[0].get_text()

    batch.append({
            "id": unit_id,
            "name": unit_name,
            "country": unit_country
        })
    
    print(f"name = {unit_name}, id = {unit_id}")


if batch:
    post_vehicle_batch("http://localhost:8080/api/v1/vehicle/batch", batch)


#




# payload = {
#     "name":unit_name
# }


# put_vehicle("http://localhost:8080/api/v1/vehicle/"+unit_id, payload)


#for readible name: <div class="game-unit_name">BT-5</div>


# for element in elements:
#     print(f"info:{element.get("href")}")


# name = soup.find('h1', class_='mw-first-heading').text.strip()
# print(f'Vehicle Name: {name}')

# <a class="wt-tree_item-link" href="/unit/ussr_t_28_1938"></a>
# https://wiki.warthunder.com/ground?v=t&t_c=ussr
# https://wiki.warthunder.com/unit/ussr_t_60_1941