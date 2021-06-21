<template>
    <div>
        <div class="row">
            <q-table
              class="my-sticky-header-table"
              title="Categories"
              :data="categories"
              :columns="columns"
              virtual-scroll
              :pagination.sync="pagination"
              :rows-per-page-options="[0]"
              :virtual-scroll-sticky-size-start="48"
              flat
              bordered
            >
            <template v-slot:header="props">
              <q-tr :props="props">
                <q-th auto-width />
                <q-th
                  v-for="col in props.cols"
                  :key="col.name"
                  :props="props"
                >
                  {{ col.label }}
                </q-th>
              </q-tr>
            </template>

            <template v-slot:body="props">
              <q-tr :props="props">
                <q-td auto-width>
                  <q-btn size="sm" color="accent" icon="delete" round dense @click="deleteRow(props.row.id)" />
                </q-td>
                <q-td
                  v-for="col in props.cols"
                  :key="col.name"
                  :props="props"
                >
                  {{ col.value }}
                </q-td>
              </q-tr>
            </template>
            </q-table>
        </div>
    </div>
</template>

<script>
// import Vue from 'vue'
// Importovanje servisa umjesto cumbersome Vuea i stalnog rada sa njim, sve definisano u servisu
import CategoryService from '../../services/rest-services/category.service.js'
export default {
  data () {
    return {
      pagination: {
        rowsPerPage: 0
      },
      categories: [],
      columns: [
        { name: 'NAME', label: 'NAME', field: 'name', sortable: true }
      ]
    }
  },
  // async/await varijanta slanja http zahtjeva kad god ocekujemo neku povratnu informaciju sa servera za npr. prikaz ili proracun
  // , veoma dobro za nauciti
  async created () {
    const response = await CategoryService.getAllCategories()
    console.log(response)
    this.categories = response.data // Cilja listu koja se nalazi u data()
  },
  methods: {
    deleteRow (id) {
      if (confirm('Are you sure you want to delete this category?')) {
        console.log(id)
        CategoryService.deleteCategory({ id: id }).then(response => {
          if (response.status === 200) {
            this.afterDelete()
            console.log('Success')
          } else {
            console.log('Error')
            console.log(response)
          }
        })
          .catch(err => console.log(err))
      }
    },

    afterDelete () {
      this.$emit('afterDelete')
    }
  }
}
</script>

<style lang="scss">
    .q-table__top,
    .q-table__bottom,
    thead tr:first-child th {
      background-color: $primary;
      color: $secondary;
    }

    thead tr th {
      position: sticky;
      z-index: 1;
    }
    thead tr:first-child th {
      top: 0;
    }

    .my-sticky-header-table {
      height: 350px;
      width: 100%;
      min-width: 300px;
    }
</style>
