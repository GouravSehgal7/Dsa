parking lot system that manage vehicles enter and exit at multi floor

lets assume we have a parking lot with n floor and k parking spot

on entry we can give it some ticket with timestamp of exit for that car and while exit we can take that ticket and charge accordingly

payment service can be either via upi or phonepay

Functional requirements

transaction management

price based on timestamp dedicated and vehicualr type

ticket generation based on the vehical type

Non functional

i think i am not sure

Core entities

Vehical type and price for that vehical

we can make abstract/interface and inherit with core vehicales

transaction type interface with core class interface

combine class handling business logic between vehical type , time spend and according to that deciding the fee

central library management
