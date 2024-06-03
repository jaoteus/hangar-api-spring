# ✈️ Hangar API

## 📜 Introduction

This API allows the developer to add, update, read and delete an aircraft or Hangar from the database. I created this AṔI just for studies and to test knowledge, it is likely that over time I will modify the code and consequently update this README.

## 🎯 Goals

- Develop an API REST with Spring.

## 📚 Index

- [Resources](#-resources)
- [Technologies Used](#-technologies-used)
- [Project Structure](#-project-structure)
- [Endpoints](#-endpoints)
    - [Query all aircraft](#query-all-aircraft)
    - [Query an aircraft](#query-an-aircraft-by-id)
    - [Update an aircraft](#update-an-aircraft-by-id)
    - [Add an aircraft](#add-an-aircraft)
    - [Remove an aircraft](#remove-an-aicraft-by-id)
    - [Query all hangars](#query-all-hangars)
    - [Query a hangar](#query-a-hangar-by-id)
    - [Add a hangar](#add-a-hangar)
    - [Update a hangar](#update-a-hangar-by-id)
    - [Add an aircraft to the hangar](#add-an-aircraft-to-the-hangar)
    - [Remove an aircraft from the hangar](#remove-an-aircraft-from-the-hangar)
    - [Remove a hangar](#remove-a-hangar-by-id)
- [How to Run](#-how-to-run)
- [License](#-license)

## 🛠 Resources

- Query all aircraft.
- Query an aircraft.
- Add an aircraft.
- Update an aircraft.
- Remove an aircraft.
- Query all hangars.
- Query a hangar.
- Add a hangar.
- Update a hangar.
- Remove a hangar.
- Add an aircraft to the hangar.
- Remove an aircraft from the hangar.

## 🎧 Technologies Used

- Java 17
- Spring Boot 3.3.0
- PostgresSQL
- Maven
- Spring Web
- Hibernate
- Docker

## 📂 Project Structure

The `division` of project layers will be:

- `Config`
- `Controller`
- `Repository`
- `Model`
- `Exception`

## 🔍 Endpoints

### Query all aircraft

- **Route:** `GET /aircrafts`
- **Description:** Returns a list of all added aircraft.

Please note that we will receive a list of all aircraft:

![get all aircraft](https://github.com/jaoteus/hangar-api-spring/assets/128613422/1222473e-3bab-4d04-bd7b-1cab33f75a42)

---

### Query an aircraft by ID

- **Route:** `GET /aircrafts/{id}`
- **Description:** Return an aircraft.
- **Example:**

Note that, unlike the request we made previously, this time it only returned one aircraft. If there is no aircraft with the id you provided, you will receive a Not Found error.

![Screenshot from 2024-05-30 19-50-38](https://github.com/jaoteus/hangar-api-spring/assets/128613422/a1d19512-7bdd-49ed-aad2-40916020d09e)

---

### Add an aircraft

- **Route:** `POST /aircrafts`
- **Description:** Add an aircraft.
- **Example:**

In this request we will add a new aircraft, but pay attention to the `aircraftStatus` field which is set to `IN_MAINTENANCE`, as we will mention it in the future.

![Screenshot from 2024-05-30 19-52-56](https://github.com/jaoteus/hangar-api-spring/assets/128613422/83b18ce3-4e15-4133-af0d-f69bb639da4b)

We will make another request to obtain all the aircraft, and notice that the aircraft we added previously is already saved and it is the last one on the list, keep this information:

![Screenshot from 2024-05-30 19-53-45](https://github.com/jaoteus/hangar-api-spring/assets/128613422/3c7e98b4-baf3-4aa6-a315-c7846e33a8d4)

---

### Update an Aircraft by id

- **Route:** `PUT /aircrafts/{id}`
- **Description:** Update an aircraft.
- **Example:**

Now we will update the aircraft that we added earlier, you probably noticed that when we added this aircraft, the `aircraftStatus` field was as `IN_MAINTENANCE`, but now we will put this field as
`ACTIVE`:

![Screenshot from 2024-05-30 19-54-58](https://github.com/jaoteus/hangar-api-spring/assets/128613422/9bf47567-c437-46dd-814b-8951ca94c92f)

We'll make another `GET` request, but this time, we're specifically looking for the id of the aircraft we added and just updated:

![Screenshot from 2024-05-30 19-55-13](https://github.com/jaoteus/hangar-api-spring/assets/128613422/b10e412d-2d36-47a3-ad8c-76c66bf274c8)

---

### Remove an Aicraft by id

- **Route:** `DELETE /aircrafts/{id}`
- **Description:** Remove an aircraft.

Now we will delete the aircraft that we added and updated previously:

![Screenshot from 2024-05-30 19-56-07](https://github.com/jaoteus/hangar-api-spring/assets/128613422/e514eae4-5fe4-479b-988c-3730603bb534)

We will make another `GET` request, but this time we will get all the aircraft, and you can notice that before, the aircraft with id 10, which was the one we just deleted, was last on the list, but now it is not It's more, because we just deleted it:

![Screenshot from 2024-05-30 19-56-39](https://github.com/jaoteus/hangar-api-spring/assets/128613422/8c200d6e-cd52-40d5-8b17-1aad1f7a61ec)

---

### Query all hangars

- **Route:** `GET /hangars`
- **Description:** Returns a list of all the hangars added along with all the aircraft in the hangar.

Note that we will receive a list of all hangars and all aircraft that the hangar has:

![Screenshot from 2024-05-30 19-59-27](https://github.com/jaoteus/hangar-api-spring/assets/128613422/aa318344-535d-4d2e-a5c7-d76b9c0390cc)

---

### Query a hangar by id

- **Route:** `GET /hangars/{id}`
- **Description:** Returns a hangar along with all the aircraft in the hangar.

Unlike the previous request, this request will only return a hangar, if there is no hangar with the id you passed, you will receive a Not Found error.

![Screenshot from 2024-05-30 19-59-39](https://github.com/jaoteus/hangar-api-spring/assets/128613422/4a277626-62aa-4e31-89e8-39feb496c1be)


---

### Add a hangar

- **Route:** `POST /hangars`
- **Description:** Add a hangar.

In this request, we will add a hangar:

![Screenshot from 2024-05-30 20-07-53](https://github.com/jaoteus/hangar-api-spring/assets/128613422/90c7d96c-1c1c-4ffd-957b-ee3b9ccc2c56)

Now let's check if we can actually create the hangar, let's make another `GET` request to return all the hangars.
Look at the `aircrafts` field, we have an empty list as we haven't added any aircraft yet, but this will change, stay tuned :).

![Screenshot from 2024-05-30 20-08-19](https://github.com/jaoteus/hangar-api-spring/assets/128613422/7bb25a20-2e0e-41fc-97e4-41f4a8059dde)

---

### Update a hangar by id

- **Route:** `PUT /hangars/{id}`
- **Description:** Update a hangar.
- **Example:**

Now let's update the hangar that has the id 2, which before (I didn't show it) it had the `name` equal to `Hangar Militar da Base Aérea de Anápolis`, but now we will shorten it further, we will just put `Base Aérea of Anápolis`, notice:

![Screenshot from 2024-05-30 20-01-32](https://github.com/jaoteus/hangar-api-spring/assets/128613422/04b4bbce-fac2-4f31-8586-3b56e028387c)

We will make another `GET` request to specifically obtain the hangar with id 2, you can see that the field was updated successfully:

![Screenshot from 2024-05-30 20-05-01](https://github.com/jaoteus/hangar-api-spring/assets/128613422/b5bc06a6-0374-4a9c-af58-ca96cc21d2d5)

---

### Add an aircraft to the hangar

- **Route:** `POST /hangars/{id}/aircrafts/{id}`
- **Description:** Add an aircraft to the hangar.

In this request, we will add an aircraft that has id 10 to the hangar that has id 4 (the hangar we added previously):

![Screenshot from 2024-05-30 20-11-45](https://github.com/jaoteus/hangar-api-spring/assets/128613422/6514c028-d800-4069-bb55-9b4c3d6e0ec5)

Remember that before our `aircrafts` field had an empty list? Now it isn't anymore, as we just added an aircraft.

![Screenshot from 2024-05-30 20-12-08](https://github.com/jaoteus/hangar-api-spring/assets/128613422/22e45fa5-01ea-4645-9cd7-dc8bb46b7484)

---

### Remove an aircraft from the hangar

- **Route:** `DELETE /hangars/{id}/aircrafts/{id}`
- **Description:** Remove an aircraft from the hangar.

To remove an aircraft, the route is the same as the previous one, the difference is that now the request type is `DELETE`, that is, now we are removing the aircraft that has id 10, from our hangar that has id 4:

![Screenshot from 2024-05-30 20-12-28](https://github.com/jaoteus/hangar-api-spring/assets/128613422/167c784e-1ef8-4178-8214-1c0308993e97)

Now the `aircrafts` field is back to an empty list, as we just removed an aircraft:

![Screenshot from 2024-05-30 20-12-43](https://github.com/jaoteus/hangar-api-spring/assets/128613422/8c68ec76-4dcc-4235-9d9c-97124cbeb588)


---

### Remove a hangar by id

- **Route:** `DELETE /hangars/{id}`
- **Description:** Remove a hangar by id.

In this request, we will remove the hangar that we initially added, which has id 4:

![Screenshot from 2024-05-30 20-55-33](https://github.com/jaoteus/hangar-api-spring/assets/128613422/3785b58a-9eaf-49a6-b2a8-4d7a35521147)

Now, let's make another request `GET`, and notice that the hangar is not present, as we just removed it:

![Screenshot from 2024-05-30 20-56-24](https://github.com/jaoteus/hangar-api-spring/assets/128613422/9b633206-ba75-494d-8dd3-7d4502ecb609)

---

## 🚀 How to Run

Clone the repository:
```sh
git clone https://github.com/jaoteus/hangar-api-spring.git
```

Navigate to the project directory:
```sh
cd hangarapi/
```
Now upload the container with Postgres with the following command (on Linux):
```sh
sudo docker-compose up -d
```
The file `docker-compose.yml` is already in the project.

Now compile and run the application:

```sh
mvn clean install
mvn spring-boot:run
```


### 📄 License
This project is licensed under the MIT License. See the LICENSE file for more details.

---
