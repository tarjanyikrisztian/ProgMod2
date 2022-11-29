import { useState } from 'react'
import reactLogo from './assets/react.svg'
import './App.css'

function App() {
  const [user, setUser] = useState(null)
  const [osszKonyv, setOsszKonyv] = useState(null)
  const [kolcsKonyv, setKolcsKonyv] = useState(null)

  //get current year
  const date = new Date()
  const year = date.getFullYear()

  const returnKonyv = (konyv_id) => {
  }

  const getUser = (id) => {
    
    fetch(`http://localhost:3001/vendeg/get/${id}`)
      .then((res) => res.json())
      .then((data) => {
        setUser(data)
      })
  }

  const getOsszKonyv = () => {
    fetch(`http://localhost:3001/konyv/getall`)
      .then((res) => res.json())
      .then((data) => {
        setOsszKonyv(data)
      })
  }



  return (
    <div className="App">
      {user ? (
        <>
            <h1>Könyvek</h1>
          <div className="konyvek">
            <div className="osszes">
              <h2>Összes könyv</h2>
              {osszKonyv ? (
                <ul>
                  <li>Harry Potter <button>Kikölcsönzés</button></li>
                  <li>Lord of the Rings <button>Kikölcsönzés</button></li>
                  <li>Game of Thrones <button>Kikölcsönzés</button></li>
                </ul>
              ) : (
                <p>
                  Nincsenek könyvek
                </p>
              )}
              <h3>Új könyv:</h3>
              <form action="" method="post">
                <span>
                  <label htmlFor="">Cím: </label>
                  <input type="text" name="konyv" id="konyv" />
                </span>
                <span>
                  <label htmlFor="">Szerző: </label>
                  <input type="text" name="szerzo" id="szerzo" />
                </span>
                <span>
                  <label htmlFor="">Kiadó: </label>
                  <input type="text" name="kiado" id="kiado" />
                </span>
                <span>
                  <label htmlFor="">Kiadás éve: </label>
                  <input type="number" name="kiadas" id="kiadas" min={1000} max={year} />
                </span>
                <button type="submit">Hozzáadás</button>
              </form>
            </div>
            <div className="kolcsonzott">
              <h2>Kikölcsönzött könyvek</h2>
              {kolcsKonyv ? (
                <ul>
                  <li>Harry Potter <button>Visszavitel</button></li>
                  <li>Lord of the Rings <button>Visszavitel</button></li>
                </ul>
              ) : (
                <p>
                  Nincsenek kikölcsönzött könyvek
                </p>
              )}
            </div>
          </div>
          <h2>{user.nev}</h2>
          <button onClick={() => setUser(null)}>Kijelentkezés</button>
        </>
      ) : (
        <div className="auth">
          <h1>Bejelentkezés</h1>
          <form action="" method="post">
            <span>
              <label htmlFor="">Id: </label>
              <input type="number" name="nev" id="nev" min={0} />
            </span>
          <button onClick={() => setUser({ id: 1, nev: 'John Doe' })}>
            Bejelentkezés
          </button>
          </form>
          <h1>Regisztráció</h1>
          <form action="" method="post">
            <span>
              <label htmlFor="">Név: </label>
              <input type="text" name="nev" id="nev" />
            </span>
            <span>
              <label htmlFor="">Telefonszám: </label>
              <input type="text" name="telefon" id="telefon" />
            </span>
            <button onClick={() => setUser({ id: 1, nev: 'John Doe' })}>
            Regisztráció
          </button>
          </form>
        </div>
      )}
    </div>
  )
}

export default App
