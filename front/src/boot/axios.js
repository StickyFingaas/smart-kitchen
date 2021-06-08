import axios from 'axios'
import Vue from 'vue'

axios.defaults.baseURL = 'http://localhost:8080/rest/'

Vue.prototype.$axios = axios
