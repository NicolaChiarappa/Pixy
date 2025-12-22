# What is the problem

Searching for—and above all, choosing—a new component for your photography kit is often not easy. You often find yourself opening various websites to check compatibility, reviews, prices, use cases, and sample photos. You then have to calculate fragmented data in various formats to find the best product for your needs.

The goal is to create a platform that normalizes data, groups it, and produces—based on the current photography kit and the photographer's needs—a list of components sorted by relevance, price, etc.

# How I solve it

The platform features a database of the main types of components (bodies, lenses, adapters), exposes CRUD operations, and implements a compatibility engine that calculates compatibility between different devices.

### Compatibility Engine

The compatibility output is not a simple boolean but a range of structured values.

In order, we have:

- **COMPATIBLE**: the two components are fully compatible and none of the functions are compromised.
- **LIMITATIONS**: the two components are physically compatible, but the combination presents functional limitations (e.g., autofocus disabled, adapter required, etc.).
- **INCOMPATIBLE**: the two components are not compatible at all.

### REST API & Security

To access the platform's features, you can use HTTP endpoints. Furthermore, all routes are protected, and access is only possible after registering and obtaining a JWT (JSON Web Token).


### API Documentation
<a id="table"></a>
![WIP](https://img.shields.io/badge/status-WIP-orange)

| METHOD | PATH | REQUESTPARAM | REQUESTBODY                         |
| --- | --- | --- |-------------------------------------|
| **POST** | `/api/user/signup` | - | [Esempio JSON](#signup)             |
| **POST** | `/api/user/login` | - | [Esempio JSON](#login)              |
| **POST** | `/api/camera` | - | [Esempio JSON](#createcamera)       |
| **PATCH** | `/api/camera` | - | [Esempio JSON](#upgradecamera)      |
| **GET** | `/api/camera/{id}` | `id`  | -                                   |
| **POST** | `/api/lens` | - | [Esempio JSON](#createlens)         |
| **GET** | `/api/lens/{id}` | `id`  | -                                   |
| **POST** | `/api/manufacturer` | - | [Esempio JSON](#createmanufacturer) |
| **GET** | `/api/manufacturer` | `id`  | -                                   |

---

### JSON requests examples

<a id="signup"></a>
### User signup

Endpoint: `POST /api/user/signup`



```json
{
  "firstName": "Nicola",
  "lastName": "Rossi",
  "email": "nick@example.com",
  "username": "nicola88",
  "password": "password123",
  "birthDate": "1990-05-20",
  "gender": "MALE",
  "photoUrl": "http://example.com/p.jpg",
  "role": "ADMIN"
}
```

[Back to table](#table)

<a id="login"></a>
### User login

Endpoint: `POST /api/user/login`



```json
{
  "username": "nicola88",
  "password": "password123"
}
```
[Back to table](#table)

<a id="createcamera"></a>
### Camera creation

Endpoint: `POST /api/camera`



```json
{
  "name": "Alpha 7 IV",
  "mounts": ["SONY_E"],
  "manufacturerId": 1,
  "releaseDate": "2021-10-21",
  "marketStatus": "ACTIVE",
  "megapixels": 33,
  "format": "FULLFRAME"
}
```
[Back to table](#table)

<a id="upgradecamera"></a>
### Camera upgrade
**NOTE: Enable to set a camera's successor**

Endpoint: `PATCH /api/camera`


```json
{
  "oldId": 1,
  "newId": 2
}
```
[Back to table](#table)

<a id="createlens"></a>
### Lens creation

Endpoint: `POST /api/lens`



```json
{
  "name": "FE 24-70mm F2.8",
  "mounts": ["SONY_FE"],
  "manufacturerId": 1,
  "releaseDate": "2022-04-27",
  "marketStatus": "ACTIVE",
  "focalLength": {
    "minimumLength": 24,
    "maximumLength": 70
  },
  "aperture": {
    "minimumAperture": 2,
    "maximumAperture": 22
  }
}
```
[Back to table](#table)

<a id="createmanufacturer"></a>
### Manufacturer creation

Endpoint: `POST /api/manufacturer`



```json
{
  "name": "Sony"
}
```
[Back to table](#table)