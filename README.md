# System Overview
**O FILA** coordinates the entire service process from ticket issuance to service completion, ensuring that customers are directed to the appropriate service counters while maintaining priority rules and waiting time standards. The system focuses on four core entities:

<img src="./public/Diagram.svg" alt="Diagrama do Sistema O FILA" style="width: 100%; height: 458px;" />

  - **Tickets (Senha)**: Digital or physical tokens issued to customers upon arrival, containing information about their service category, issue time, and priority level.
  
  - **Categories (Categoria)**: Service types that determine ticket priorities, maximum waiting times, and special handling requirements (such as preferential treatment for elderly, disabled, or other priority groups).
  
  - **Service Counters (Guichê)**: Physical or virtual points where customers receive service, configured to handle specific categories of requests.
  
  - **Locations (Local)**: Physical facilities where the service is provided, which can host multiple service counters and categories.

## **Key Features**

  - **Smart Ticket Distribution**: Issues appropriate tickets based on service needs and directs customers to the correct waiting areas.
  
  - **Priority Management**: Handles customer prioritization according to service categories and waiting time thresholds.
  
  - **Counter Management**: Efficiently assigns service counters to different categories and manages counter availability.
  
  - **Real-time Monitoring**: Tracks waiting times and service times to prevent delays and ensure compliance with service level agreements.
  
  - **Statistics and Reports**: Provides management with valuable insights about service efficiency, peak times, and resource utilization.

## **Technical Architecture**

The system follows the Model-View-Controller (MVC) architecture pattern for clean separation of concerns:

  - **Model Layer**: Contains the core business entities (Ticket, Category, Counter, Location) and their relationships.
  
  - **Controller Layer**: Implements business logic for managing tickets, categories, and service counters.
  
  - **View Layer**: Provides interfaces for users to interact with the system, including displays for customers and management consoles for administrators.


O FILA is designed with scalability in mind, allowing it to be deployed in small facilities with few service points or large organizations with dozens of counters and multiple service categories. The system prioritizes clean code principles and maintainable architecture to ensure long-term reliability and ease of enhancement.
