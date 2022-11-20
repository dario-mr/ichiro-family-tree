# Ichiro Family Tree
API that provides the family tree of our doggy Ichiro Go Takimisou.

## Environment variables to set
- `IFT_PROFILE`: spring profile used to run the app, either `dev` or `prod`. Default: `prod`.
- `IFT_API_KEY`: API key to authorize endpoint requests. Consumers of this API Must include it in the request header with key `api-key`.
- `TNS_ADMIN`: path of the folder containing the `tnsnames.ora` file for connecting to the Oracle DB.
- `DB_PASSWORD`: password to the Oracle DB containing this app database.