# Bank-App

Small banking demo built

## What it does  
* Create an account (`BankService#createAccount`)  
* Deposit or withdraw funds (`deposit`, `withdraw`)  
* Retrieve balance (`balance`)

## Tests  
`BankServiceTest` covers  
1. Deposit happy path  
2. Withdrawal happy path  
3. Attempted overdraft (negative scenario)

Run locally:

```bash
mvn test
