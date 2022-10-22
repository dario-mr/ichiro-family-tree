# Ichiro Family Tree
API that provides the family tree of our doggy Ichiro Go Takimisou.

## Environment variables to set
- `API_KEY`: API key to authorize endpoint requests. Consumers of this API Must include it in the request header with key `api-key`.
- `TNS_ADMIN`: path of the folder containing the `tnsnames.ora` file (or wallet) for connecting to Oracle DB.
  - if using an OCI DB, this folder must contain the DB wallet, downloadable from the "DB Connection" section in the Oracle DB dashboard.
- `DB_PASSWORD`: password to the Oracle DB containing this app database.
- `IFT_PROFILE`: spring profile used to run the app, either `dev` or `prod`. Default: `prod`.