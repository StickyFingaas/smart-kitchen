import Vue from 'vue'

// Pathovi su uzeti sa backa i samo napisani (mogu se provjeriti na quasar 8080/# pathu u browseru)
const PATH_GET = 'getAllItems'
const PATH_POST = 'createItem'
const PATH_DELETE = 'deleteItemById?id='

const ItemService = {
  getAllItems: () => Vue.prototype.$axios.get(`${PATH_GET}`),
  createItem: (item) => Vue.prototype.$axios.post(`${PATH_POST}`, item),
  deleteItem: (id) => Vue.prototype.$axios.delete(`${PATH_DELETE}${id}`)
}
// Vazno je da se eksportuje da bi se moglo koristiti u drugim fajlovima
export default ItemService
