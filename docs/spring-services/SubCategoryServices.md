 # Endpoint details for Sub category services

## Add sub category
 - This API is to add sub categories

### Service Description
 - URL: `http://host:port/addsubcat`
 - Method: `POST`
 - URL Params:
    * Required: N/A
    * Optional: N/A
 - form-data :
 
        subcat: { "type": "Education", "name":"SIT" }
 
        logo: { "filename":"sit.png", "description": "SIT college logo" }
 
        file: {file attachment} 

### Response
 - Success Response:
    * Code: 200 OK
    * Content: `Successfully added {name} to sub category {type}`
 - Error Response: 
    * Code: 4xx | 5xx
    * Content:
     
            {
                    "timestamp": 1527001929325,
                    "status": 400,
                    "error": "Bad Request",
                    "exception": "org.springframework.web.multipart.support.MissingServletRequestPartException",
                    "message": "Required request part 'file' is not present",
                    "path": "/addsubcat"
            }
    

## List sub categories
 - This API is to list sub categories

### Service Description
 - URL: `http://host:port/{type}`
 - Method: `GET`
 - Options: Education | Restaurant | Attractions
 - URL Params:
    * Required: N/A
    * Optional: N/A
    * form-data :  N/A

### Response
 - Success Response:
    * Code: 200 OK
    * Content: 
    
            [
                  {
                    "id": "5b0233739004dc3e1d650a93",
                    "type": "Education",
                    "name": "SIT",
                    "logo": {
                      "image": "byte data",
                      "description": "SIT college logo",
                      "filename": "sit.png",
                      "contentType": "image/jpeg",
                      "created": 1526870899989
                    }
                  }
                ]
 - Error Response: 
    * Code: 4xx | 5xx
    * Content: 
    
                {
                     "timestamp": 1527002928434,
                     "status": 404,
                     "error": "Not Found",
                     "message": "No message available",
                     "path": "/Hospitals"
                 }