# Documentation
## Service URI
`http://138.68.9.11:8080/cdmr/rest/customer`

## GET
####`http://138.68.9.11:8080/cdmr/rest/customer/{param}/`



## Example
#### `http://138.68.9.11:8080/cdmr/rest/customer/1000/`

Param Field: param
Type: Int
Desc: Valid Customer Number

###Success 200

|Field|Type|Description|
|-----|----|---------------|
/custNum/int/Customer Number/
/custName/String/Customer Name/
/add1/String/Customer address/
/add2/String/Customer address/
/city/String/City/
/state/String/State/
/Zip/String/Zip code/
/Phone/String/Customer Phone number/


###Success 400
    
|Field|Type|Description|
|-----|----|---------------|
|error|String|Customer Number invalid|

###Success 404

|Field|Type|Description|
|-----|----|---------------|
|error|String|Customer not found|

###Success 500

|Field|Type|Description|
|-----|----|---------------|
|error|String|Unable to lookup customer due to technical issues|

###Example JSON Response (Success)

###Example JSON Response (Error)

###Example XML Response (Success)

<customer><add1>100</add1><add2>Manpower Place</add2><city>Milwaukee</city><custName>Experis</custName><custNum>1000</custNum><phone>414-961-1000</phone><state>WI</state><zip>53212</zip></customer>