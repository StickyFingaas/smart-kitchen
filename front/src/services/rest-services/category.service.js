import Vue from 'vue'

// Pathovi su uzeti sa backa i samo napisani (mogu se provjeriti na quasar 8080/# pathu u browseru)
const PATH_GET = 'getCategories'
const PATH_POST = 'createCategory'
const PATH_DELETE = 'deleteCategory'

const CategoryService = {
  getAllCategories: () => Vue.prototype.$axios.get(`${PATH_GET}`),
  createCategory: (item) => Vue.prototype.$axios.post(`${PATH_POST}`, item),
  deleteCategory: (id) => Vue.prototype.$axios.delete(`${PATH_DELETE}`, { data: id })
}
// Vazno je da se eksportuje da bi se moglo koristiti u drugim fajlovima
export default CategoryService
