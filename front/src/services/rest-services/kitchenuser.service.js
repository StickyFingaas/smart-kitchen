import Vue from 'vue'

const PATH1 = 'getAllKitchenUsers'
const PATH2 = 'createKitchenUser'
const PATH3 = 'deleteKitchenUserByID?id='

const KitchenUserService = {
// es6 sintaksa
// getAll: () => Vue.prototype.$axios.get(`${PATH}`)

  getAll () {
    return Vue.prototype.$axios.get(`${PATH1}`)
  },

  createUser (user) {
    return Vue.prototype.$axios.post(`${PATH2}`, user)
  },

  deleteUser (id) {
    return Vue.prototype.$axios.delete(`${PATH3}${id}`)
  }
}

export default KitchenUserService
