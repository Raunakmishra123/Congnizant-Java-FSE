# JPA and Hibernate Notes

## What is ORM?

ORM = Object Relational Mapping.

In Java, we work with objects.
In databases, we work with tables and rows.

ORM bridges this gap - it maps Java objects to database tables automatically.

| Java             | Database        |
|------------------|-----------------|
| Class            | Table           |
| Object           | Row             |
| Field            | Column          |
| @Id field        | Primary Key     |

## JPA vs Hibernate

- **JPA** (Java Persistence API) is a specification - like a contract or interface.
- **Hibernate** is an implementation of JPA - the actual working code.
- You write code against JPA, Hibernate does the work behind the scenes.

## Key JPA Annotations

```java
@Entity          // This class maps to a database table
@Table(name="country")  // Which table to use
@Id              // This field is the primary key
@GeneratedValue  // Auto-generate the primary key value
@Column          // Optional - customize column mapping
```

## Basic JPA Operations

```java
EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-unit");
EntityManager em = emf.createEntityManager();

// Save
em.getTransaction().begin();
Country india = new Country("India");
em.persist(india);
em.getTransaction().commit();

// Find
Country found = em.find(Country.class, 1L);
System.out.println(found.getName());
```
