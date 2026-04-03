# Fitness_MicroservicesProject

A comprehensive microservices-based fitness application built with Spring Boot, featuring independent services for user management, activity tracking, AI-powered recommendations, and a modern React frontend.



## 🔧 Microservices

### 1. **User Service** (`userservice/`)
Manages user authentication, profiles, and account management.
- User registration and login
- Profile management
- Authentication and authorization

### 2. **Activity Service** (`activityservice/`)
Handles fitness activity tracking and logging.
- Log user activities (workouts, exercises)
- Track activity history
- Calculate activity metrics

### 3. **AI Service** (`aiservice/`)
Provides AI-powered recommendations and insights.
- Generate personalized workout recommendations
- Analyze fitness patterns
- Provide health insights based on user data

### 4. **API Gateway** (`gateway/`)
Central entry point for all client requests.
- Request routing to appropriate microservices
- Load balancing
- Request/response filtering

### 5. **Config Server** (`configserver/`)
Centralized configuration management.
- Manages application properties
- Enables dynamic configuration updates

### 6. **Service Discovery** (`eureka/`)
Netflix Eureka for service registration and discovery.
- Automatic service registration
- Service lookup and load balancing

### 7. **Frontend** (`fitness-app-frontend/`)
React + Vite based user interface.
- Modern, responsive UI
- Real-time data updates
- Interactive fitness tracking dashboard

## 🛠️ Tech Stack

### Backend
- **Framework**: Spring Boot (Java)
- **Service Discovery**: Netflix Eureka
- **Configuration**: Spring Cloud Config
- **API Gateway**: Spring Cloud Gateway
- **Database**: MySQL / PostgreSQL (configurable)
- **Build Tool**: Maven / Gradle

### Frontend
- **Framework**: React 18+
- **Build Tool**: Vite
- **Styling**: CSS3 / Tailwind CSS (recommended)
- **HTTP Client**: Axios
- **State Management**: Context API / Redux (optional)

### DevOps & Infrastructure
- **Containerization**: Docker
- **Orchestration**: Kubernetes (optional)
- **CI/CD**: GitHub Actions / Jenkins

## 📁 Directory Structure

Fitness_MicroservicesProject/ ├── README.md 
                              ├── fitness-app-microservices-main/ │ 
                              ├── userservice/ # User management microservice │ 
                              ├── activityservice/ # Activity tracking microservice │ 
                              ├── aiservice/ # AI recommendations microservice 
                              │ ├── gateway/ # API Gateway │ 
                              ├── eureka/ # Service Discovery │ 
                              ├── configserver/ # Configuration Server 
                              │ └── fitness-app-frontend/ # React frontend application 
                              └── .idea/ # IDE configuration

Code

## 📋 Prerequisites

- **Java 11+** (for backend services)
- **Node.js 16+** (for frontend)
- **Maven 3.6+** or **Gradle 6.0+**
- **Docker** (optional, for containerization)
- **Git**

## 🚀 Setup & Installation

### 1. Clone the Repository

```bash
git clone https://github.com/palakberi/Fitness_MicroservicesProject.git
cd Fitness_MicroservicesProject
2. Backend Setup
Step 1: Start Eureka Server
bash
cd fitness-app-microservices-main/eureka
mvn clean install
mvn spring-boot:run
# Eureka Dashboard: http://localhost:8761
Step 2: Start Config Server
bash
cd ../configserver
mvn clean install
mvn spring-boot:run
# Config Server: http://localhost:8888
Step 3: Start Individual Microservices
User Service:

bash
cd ../userservice
mvn clean install
mvn spring-boot:run
# Runs on port 8081
Activity Service:

bash
cd ../activityservice
mvn clean install
mvn spring-boot:run
# Runs on port 8082
AI Service:

bash
cd ../aiservice
mvn clean install
mvn spring-boot:run
# Runs on port 8083
API Gateway:

bash
cd ../gateway
mvn clean install
mvn spring-boot:run
# Runs on port 8080
3. Frontend Setup
bash
cd fitness-app-microservices-main/fitness-app-frontend
npm install
npm run dev
# Frontend: http://localhost:5173
▶️ Running the Application
Option 1: Manual Startup (Development)
Follow the setup steps above to start each service individually.

Option 2: Docker Compose (Recommended)
Create a docker-compose.yml in the project root:

YAML
version: '3.8'
services:
  eureka:
    build: ./fitness-app-microservices-main/eureka
    ports:
      - "8761:8761"
  
  configserver:
    build: ./fitness-app-microservices-main/configserver
    ports:
      - "8888:8888"
  
  userservice:
    build: ./fitness-app-microservices-main/userservice
    ports:
      - "8081:8081"
  
  activityservice:
    build: ./fitness-app-microservices-main/activityservice
    ports:
      - "8082:8082"
  
  aiservice:
    build: ./fitness-app-microservices-main/aiservice
    ports:
      - "8083:8083"
  
  gateway:
    build: ./fitness-app-microservices-main/gateway
    ports:
      - "8080:8080"
  
  frontend:
    build: ./fitness-app-microservices-main/fitness-app-frontend
    ports:
      - "5173:5173"
Run with:

bash
docker-compose up -d
📚 API Documentation
API Gateway Base URL
Code
http://localhost:8080/api
User Service Endpoints
POST /users/register - Register a new user
POST /users/login - User login
GET /users/{userId} - Get user profile
PUT /users/{userId} - Update user profile
Activity Service Endpoints
POST /activities - Log a new activity
GET /activities/{userId} - Get user activities
PUT /activities/{activityId} - Update activity
DELETE /activities/{activityId} - Delete activity
AI Service Endpoints
GET /recommendations/{userId} - Get personalized recommendations
GET /insights/{userId} - Get fitness insights
POST /analyze - Analyze fitness dat

