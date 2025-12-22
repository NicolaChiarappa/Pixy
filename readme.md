# Qual è il problema

Spesso cercare e, soprattutto scegliere, un nuovo componente per il tuo kit fotografico non è facile. Ti ritrovi molto facilmente ad aprire svariati siti web per controllare compatibilità, recensioni, prezzi, casi d’uso e foto di esempio. Devi quindi calcolare dati frazionati e in vari formati per trovare il miglior prodotto per le tue esigenze.

L’obiettivo è quello di creare una piattaforma che normalizza i dati, li raggruppa e produce, sulla base del kit fotografico attuale e all’esigenza del fotografo, una lista di componenti ordinati per rilevanza/prezzo/ecc.

# Come lo risolvo

La piattaforma ha un database dei principali tipi di componenti (corpi, lenti, adattatori), espone le operazioni di CRUD e implementa un motore di compatibilità che calcola la compatibilità tra i diversi dispositivi.

### Motore di compatbilità

La compatibilità prodotta non è un semplice booleano ma un ventaglio di valori strutturati.

In ordine abbiamo:

- COMPATIBLE: i due componenti sono totalmente compatibili e nessuna delle funzioni viene compromessa
- LIMITATIONS: i due componenti sono fisicamente compatibili ma l’unione presenta delle limitazioni funzionali (es. autofocus disattivato, necessario adattatore, ecc.)
- INCOMPATIBILE: i due componenti non sono compatibili affatto.

### REST API & Security

Per accedere alle funzionalità della piattaforma è possibile usare endpoint HTTP. Inoltre tutte le route sono protette ed è possibile accedere solo dopo aver effettuato la registrazione ed aver ottenuto il JWT(Json Web Token).


### Documentazione API
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

### Esempi JSON di Richiesta

<a id="signup"></a>
### Registrazione Utente

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

[Torna alla tabella](#table)

<a id="login"></a>
### Login Utente

Endpoint: `POST /api/user/login`



```json
{
  "username": "nicola88",
  "password": "password123"
}
```
[Torna alla tabella](#table)

<a id="createcamera"></a>
### Creazione Fotocamera

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
[Torna alla tabella](#table)

<a id="upgradecamera"></a>
### Upgrade Fotocamera
NOTE: Consente di impostare il modello successore di una data fotocamera

Endpoint: `PATCH /api/camera`


```json
{
  "oldId": 1,
  "newId": 2
}
```
[Torna alla tabella](#table)

<a id="createlens"></a>
### Creazione Obiettivo

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
[Torna alla tabella](#table)

<a id="createmanufacturer"></a>
### Creazione Produttore

Endpoint: `POST /api/manufacturer`



```json
{
  "name": "Sony"
}
```
[Torna alla tabella](#table)