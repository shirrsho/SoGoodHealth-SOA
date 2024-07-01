
### Hasnain Iqbal (Shirsho), MSSE1962
## SoGoodHealth, Healthcare Management System

As the required course project, I have developed a Healthcare Management System, SoGoodHealth. It is designed using Service-Oriented Architecture (SOA) principles to simplify different kinds of healthcare operations. It consists of several services that simulate to work independently yet together to manage various aspects of healthcare.

```Execute "run.sh" file to run all the services. You can access the services using SOAPUI or similar tools. In case of difficulty in running you can manually run all projects also (using IDEs).```

There are **12** services altogether. *3* of them are Entity Services, *4* are Utility services, *5* are Task Services. Details about the services:

### Entity services
1. Patient Service: Keeps track of patient details, appointments, and medical records.
2. Doctor Service: Manages doctor information, and schedules.
3. Medical Record Service: Stores and retrieves patient medical histories.
### Utility Services
4. Authentication Service: Handles user login and access permissions.
5. Notification Service: Sends messages to patients, doctors, and staff about appointments and system updates.
6. Logging Service: Records events and errors for monitoring and fixing issues.
7. Search Service: Search through the application.
### Task Services
8. Appointment Management Service: Coordinates the process of booking, confirming, and canceling appointments by using other services like Patient and Doctor.
9. Billing Service: Handles payments and invoices related to healthcare services.
10. Report Generation Service: Creates reports on patient data, doctor performance, and system usage.
11. Inventory Management Service: Manages stocks and limits of different healthcare items.
12. Insurance Management Service: Manages insurance of the patients.

## Implemented SOA Principles
Each service adheres to the principles of SOA.
### 1. Schema Centralization:
All schemas are defined and reused across the application according to need, ensuring consistency and ease of maintenance.
I used standardized formats (XML schemas) across services like Patient and Doctor to keep data organized consistently. The schema for patient details is used in patient management, appointment scheduling, and medical records services.

### 2. Loose Coupling:
Services are designed to operate independently, reducing dependencies and increasing flexibility. Each service operates on its own without depending too much on others.
For example, the notification service operates independently and can send alerts regardless of the other services' states.

### 3. Abstraction:
Services are described in a way (WSDL files) that hides the technical details. This makes it simpler for different parts of the system to work together without needing to know exactly how each service works internally.
Clients and other services interact with the patient service through a well-defined WSDL without knowing the underlying logic.

### 4. Reusability:
Services are designed for reuse across different parts of the system.
Common tasks like logging, authentication, and notifications are handled by dedicated services. These services can be used across different parts of the system. The authentication service can be reused by various services for validating user credentials.

### 5. Autonomy:
Each service can do its job without relying on what other services are doing at the same time. This independence makes the system more reliable and easier to fix if something goes wrong. For example, the billing service functions independently and does not rely on other services to manage billing information.

### 6. Statelessness:
Services are designed to be stateless, with each request being independent.
Services don’t remember what happened in previous interactions. Each request is handled on its own, which helps in managing many requests at once without getting mixed up or slow.
The logging service records each log entry independently, without needing context from previous requests.

### 7. Composability:
Services are designed to be composable, allowing for the creation of complex workflows.
Some services coordinate bigger tasks by using smaller services together. For example, managing appointments involves steps like checking availability, notifying patients, and confirming bookings. Each of these steps is managed by different services that work well together.

----

Therefore, I have fullfilled the required tasks for the project. Hoping for the best.
#### Thank you,
#### Hasnain Iqbal (Shirsho),
#### MSSE 1962