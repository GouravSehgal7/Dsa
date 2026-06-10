1. Architectural Patterns

These define the overall structure of your backend.

Layered Architecture
Controller
   ↓
Service
   ↓
Repository
   ↓
Database

Used in:

Express
NestJS
Spring Boot
ASP.NET
MVC (Model View Controller)
Request
   ↓
Controller
   ↓
Model
   ↓
Response

Used in:

Django
Laravel
Rails
Clean Architecture

Popularized by Robert C. Martin

Frameworks
    ↓
Adapters
    ↓
Use Cases
    ↓
Entities

Dependencies point inward.

Hexagonal Architecture

Also called:

Ports and Adapters
API
 ↓
Port
 ↓
Business Logic
 ↓
Port
 ↓
Database

Makes replacing databases and APIs easy.

Microservices
Auth Service
User Service
Payment Service
Notification Service

Each service has its own database.

Event Driven Architecture
Order Created
      ↓
Events
      ↓
Email Service
Inventory Service
Analytics Service

Uses events instead of direct calls.

2. Data Access Patterns
Repository Pattern
UserRepository

Hides database implementation.

DAO (Data Access Object)

Similar to Repository.

UserDAO

Direct database operations.

Unit of Work

Tracks multiple database changes.

Insert User
Insert Order
Update Inventory

Commit all together.

Identity Map

Avoids loading same object multiple times.

User #1 loaded
User #1 requested again
Return cached version
Data Mapper

ORM pattern.

Database Row
     ↔
Object

Used by:

TypeORM
Sequelize
Hibernate
Active Record

Object saves itself.

user.save()
user.delete()

Used by:

Rails
Laravel Eloquent
3. Object Creation Patterns
Factory Pattern

Creates objects.

PaymentFactory.create("stripe")
Abstract Factory

Creates families of related objects.

Create Mongo Objects
Create Postgres Objects
Builder Pattern

Step-by-step object creation.

new QueryBuilder()
 .select("*")
 .where(...)
 .limit(...)
Singleton

Only one instance.

DatabaseConnection
4. Behavioral Patterns
Strategy Pattern

Swap algorithms.

JwtAuthStrategy
GoogleAuthStrategy
GithubAuthStrategy
Observer Pattern

Subscribe to changes.

Event
 ↓
Subscribers
Command Pattern

Encapsulate actions.

CreateUserCommand
DeleteUserCommand
Chain of Responsibility

Request passes through handlers.

Auth Middleware
      ↓
Validation Middleware
      ↓
Controller

Express middleware is a classic example.

State Pattern

Object behavior changes based on state.

Pending
Processing
Completed
Cancelled
Template Method

Base workflow with customizable steps.

Validate
 ↓
Process
 ↓
Save
Mediator Pattern

Components communicate through mediator.

Component
   ↓
Mediator
   ↓
Other Components
5. Messaging Patterns
Publish Subscribe
Publisher
   ↓
Message Broker
   ↓
Subscribers

Kafka, RabbitMQ.

Message Queue
Producer
   ↓
Queue
   ↓
Consumer
Event Sourcing

Store events instead of state.

MoneyDeposited
MoneyWithdrawn

Rebuild state from events.

CQRS

Command Query Responsibility Segregation

Writes
  ↓
Database

Reads
  ↓
Read Model

Separate read and write paths.

6. Distributed System Patterns
API Gateway
Client
  ↓
Gateway
  ↓
Services
Circuit Breaker

Prevents cascading failures.

Service Down
   ↓
Stop Requests
Retry Pattern
Fail
 ↓
Retry
Bulkhead Pattern

Isolate resources.

Payments Pool
Search Pool
Email Pool
Saga Pattern

Distributed transactions.

Order
 ↓
Payment
 ↓
Inventory
 ↓
Shipping

Rollback on failure.

7. Caching Patterns
Cache Aside
Check Cache
    ↓
Miss
    ↓
Database
    ↓
Cache

Most common