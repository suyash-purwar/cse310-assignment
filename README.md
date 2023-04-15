# Car Rental System

### Problem Statement

Implement a system for use by a car hire company. The system must be able to keep records of cars in the fleet and to book a car to a particular customer with the dates of the booking. The system must be able to provide a series of reports, for example being able to report the details of each vehicle including its booking dates, being able to report on the current the status of any vehicle (whether it is currently at the depot, or alternatively to whom it is booked and its return date).

### Concept

#### User Facing Options

1. Show all cars in the fleet in a table based format with details as follows:
  1.1 id
  1.2 model
  1.3 is_booked
2. Add new car to fleet.
  2.1 Auto-increment id
  2.2 model
3. Show detailed status of the car based on the id.
  3.1 id
  3.2 model
  3.3 date when added to the fleet
  3.4 booking_status
  3.5 date_of_booking
  3.6 booked_by (Name)
4. Book Car
  4.1 Enter customer name and car_id. If the car is availablE, it'll be booked
5. Return Car
  5.1 Enter customer id and booking_id
  5.2 If for a customer_id the provided booking_id is found, the car's booking_status will change to available, otherwise it'll show no car booking found for that customer


#### Classes

1. 
