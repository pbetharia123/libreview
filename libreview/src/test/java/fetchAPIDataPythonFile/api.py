import requests
import json

response = requests.get('https://datausa.io/api/data?drilldowns=Nation&measures=Population')
count = len(response.json()['data'])
name = response.json()['source'][0]['annotations']['source_name']

year_list = []
for i in range(0, count):
    yrs = response.json()['data'][i]['Year']
    year_list.append(yrs)

frm_year = year_list[count-1]
to_year = year_list[0]

frm_year = int(frm_year)
to_year = int(to_year)
in_year = to_year - frm_year

yr = []
population = []
percent_increase = []

for x in range(0, count - 1):
    years = response.json()['data'][x]['Year']
    pop = response.json()['data'][x]['Population']
    pop1 = response.json()['data'][x+1]['Population']
    calc = (pop - pop1)*100/pop1
    calc = round(calc, 2)
    yr.append(years)
    population.append(pop)
    percent_increase.append(calc)
    maxvalue = max(percent_increase)
    minvalue = min(percent_increase)
    max_pos = percent_increase.index(max(percent_increase))
    min_pos = percent_increase.index(min(percent_increase))
    max_year = yr[max_pos]
    min_year = yr[min_pos]

print("According to ", name, ", in ", in_year, " years from ", frm_year," to ", to_year, " , peak population growth was ", maxvalue, "% in ", max_year, " and lowest population increase was ", minvalue, "% in ", min_year)
