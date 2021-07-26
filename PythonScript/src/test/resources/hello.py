"""
web scraping
>> pip install requests
>> pip install lxml
>> pip install bs4
"""

import requests
import bs4

result = requests.get("https://ae.indeed.com/")
#result = requests.get("https://169.45.207.192/")
#print(type(result))

soup = bs4.BeautifulSoup(result.text, "lxml")
#print(type(soup.select("body")[0]))
bodyVar = soup.select("body")[0].getText()
print(bodyVar.encode('utf-8', 'replace'))


