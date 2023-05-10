    API REST Con métodos CRUD
Dependencias:
1. Spring Boot Dev Tools
2. Spring Web
3. Spring Data JPA
4. Swagger-UI

Aplicacion API REST con acceso a base de datos PostgreSQL para persistir la informacion

El acceso se puede dar desde Postman o navegador

##Entidad Persona
1. Persona:
Atributos:
id
Nombre
Apellido
Edad
2. PersonRepository
3. PersonController
4. PersonaService
    Métodos CRUD:
   1. Mostrar todos: findAll
   2. Buscar por id: findById
   3. Buscar por nombre: findByName
   4. Buscar por apellido: findByLastname
   5. Buscar por edad: findByAge
Crear nuevo cliente
    6. Create
Borrar Cliente
   7. Borrar por id: deleteById
   8. Borrar por nombre: deleteName
   9. Borrar por apellido: deleteLastname
   10. Borrar por edad: deleteByEdad
   11. Borra todos
   Actualizar Cliente
   12. Update