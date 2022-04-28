# file_upload_download
uploading and downloading Multipart File in MySQL database

## Key Take Aways
You need to set max_allowed_packet so that SQL can accept files larger than a certain threshold
```
SET GLOBAL max_allowed_packet=1073741824;
```
