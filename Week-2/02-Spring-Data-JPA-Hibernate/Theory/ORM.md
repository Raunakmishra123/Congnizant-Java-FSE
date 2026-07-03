# Object-Relational Mapping (ORM)

Object-Relational Mapping (ORM) is a technique that lets you query and manipulate data from a database using an object-oriented paradigm.

## Why ORM?

- **Eliminates Boilerplate Code:** No need to write raw SQL queries, open connections, handle statements, or manually map ResultSet fields to Java classes.
- **Database Independence:** JPA handles compiling queries into database-specific SQL dialect. You can switch from H2 to PostgreSQL or MySQL with minimal configuration changes.
- **Type Safety:** Compile-time check on entities and fields.

## Core concepts of ORM

1. **Entity:** A Java class mapped to a database table.
2. **Metadata:** Configuration that defines mappings (usually annotations like `@Entity`, `@Column`).
3. **Session / EntityManager:** The interface representing the persistence context, used to save, retrieve, update, and delete objects.
4. **Caching:** Automatically stores retrieved objects in memory to reduce database queries.
