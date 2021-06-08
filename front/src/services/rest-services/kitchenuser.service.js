import Vue from 'vue'

const PATH1 = 'getAllKitchenUsers'
const PATH2 = 'createKitchenUser'

const KitchenUserService = {
// es6 sintaksa
// getAll: () => Vue.prototype.$axios.get(`${PATH}`)

  getAll () {
    return Vue.prototype.$axios.get(`${PATH1}`)
  },

  createUser (user) {
    return Vue.prototype.$axios.post(`${PATH2}`, user)
  }
}

export default KitchenUserService
