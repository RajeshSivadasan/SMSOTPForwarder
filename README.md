# SMSOTPForwarder
Android Application
This application reads SMS for OTP pattern and sends it to AWS API Gateway(please use your own url) to update in a Dynamo DB table. This OTP can be later accessed using the same AWS API Gateway url. 

This app can be useful if you need to instantly read OTP from your adndroid device and use it in any other applications / software. 
