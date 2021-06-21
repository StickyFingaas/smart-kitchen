import Vue from 'vue'

const PATH_GET = 'getAllKitchenUsers'
const PATH_CREATE = 'createKitchenUser'
const PATH_UPDATE = 'updateKitchenUser'
const PATH_DELETE = 'deleteKitchenUserByID?id='

const KitchenUserService = {
// es6 sintaksa
  getAll: () => Vue.prototype.$axios.get(`${PATH_GET}`),
  createUser: (user) => Vue.prototype.$axios.post(`${PATH_CREATE}`, user),
  updateUser: (user) => Vue.prototype.$axios.put(`${PATH_UPDATE}`, user),
  deleteUser: (id) => Vue.prototype.$axios.delete(`${PATH_DELETE}${id}`)
}

export default KitchenUserService
