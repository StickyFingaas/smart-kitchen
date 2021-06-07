import http from '../axios.js'

class KitchenUserService {
  getAll () {
    return http.get('/getAllKitchenUsers')
  }

  create (data) {
    return http.post('/createKitchenUser', data)
  }
}
export default new KitchenUserService()
