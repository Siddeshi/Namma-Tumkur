# Endpoint details for Category services

## Add category
 - This API is to add categories

### Service Description
 - URL: `http://host:port/addcategory`
 - Method: `POST`
 - URL Params:
    * Required: N/A
    * Optional: N/A
    * form-data :
 
        category: { "type": "Education" }
 
        logo: { "filename":"edu.png", "description": "Education category logo" }
 
        file: {file attachment} 

### Response
 - Success Response:
    * Code: 200 OK
    * Content: `Added new category successfully`
 - Error Response: 
    * Code: 4xx | 5xx
    * Content:
     
            {
                    "timestamp": 1527001929325,
                    "status": 400,
                    "error": "Bad Request",
                    "exception": "org.springframework.web.multipart.support.MissingServletRequestPartException",
                    "message": "Required request part 'file' is not present",
                    "path": "/addcategory"
            }

## list categories
 - This API is to list all categories

### Service Description
 - URL: `http://host:port/listcategory`
 - Method: `GET`
 - URL Params:
    * Required: N/A
    * Optional: N/A
    * form-data :  N/A

### Response
 - Success Response:
    * Code: 200 OK
    * Content: 
    
             `[
                  {
                    "catId": "5b04429e9004dc3efcb4e30b",
                    "type": "Education",
                    "logos": {
                      "image": "byte data",
                      "description": "Education category logo",
                      "filename": "edu.png",
                      "contentType": "image/jpeg",
                      "created": 1527005854923
                    }
                  }
             ]`
 - Error Response: 
    * Code: 4xx | 5xx
    * Content:
     
            {
                    "timestamp": 1527001929325,
                    "status": 500,
                    "error": "Internal server error",
                    "exception": "",
                    "message": "Error",
                    "path": "/listcategory"
            }

## delete category
 - This API is to delete category by id

### Service Description
 - URL: `http://host:port/deletecategory?catId={id}`
 - Method: `DELETE`
 - URL Params: 
    * Required: catId=5b04429e9004dc3efcb4e30b
    * Optional: N/A
    * form-data :  N/A

### Response
 - Success Response:
    * Code: 200 OK
    * Content: 
    
             `Deleted category: {type} successfully`
 - Error Response: 
    * Code: 4xx | 5xx
    * Content:
     
            {
                    "timestamp": 1527001929325,
                    "status": 500,
                    "error": "Internal server error",
                    "exception": "",
                    "message": "Error",
                    "path": "/deletecategory"
            }


## get category by id
 - This API is to get the category by id

### Service Description
 - URL: `http://host:port/getcategorybyid?catId={id}`
 - Method: `GET`
 - URL Params:
    * Required: catId=5b04429e9004dc3efcb4e30b
    * Optional: N/A
    * form-data :  N/A

### Response
 - Success Response:
    * Code: 200 OK
    * Content: 
    
             `[
                  {
                    "catId": "5b04429e9004dc3efcb4e30b",
                    "type": "Education",
                    "logos": {
                      "image": "byte data",
                      "description": "Education category logo",
                      "filename": "edu.png",
                      "contentType": "image/jpeg",
                      "created": 1527005854923
                    }
                  }
             ]`
 - Error Response: 
    * Code: 4xx | 5xx
    * Content:
     
            {
                    "timestamp": 1527001929325,
                    "status": 500,
                    "error": "Internal server error",
                    "exception": "",
                    "message": "Error",
                    "path": "/getcategorybyid"
            }