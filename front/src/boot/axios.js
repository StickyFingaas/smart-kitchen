// Ovaj folder smo manualno kreirali i importovali axios i Vue objekat
import axios from 'axios'
import Vue from 'vue' // Vue je kao jedan ogromni parent citavog projekta i mocemo ga importovati kasnije kroz fajlove

axios.defaults.baseURL = 'http://localhost:8080/rest' // Jednostavno postavljanje urla u axios (base url naseg backenda dje ce da targetuje)

Vue.prototype.$axios = axios // Pisanje axiosa u prototip Vue objekta, sto je kao neka vrsta konstruktora za Vue objekat
