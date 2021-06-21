<template>
  <q-page class="row justify-center content-center offset-bit">
    <div class="row justify-center items-center col-10 q-gutter-xl">
      <div class="col-6">
        <category-table :key="tableKey" @afterDelete="afterCateogorySubmit()"/>
      </div>
      <div class="col-4">
        <category-form @onCategorySubmit="afterCateogorySubmit()" /> <!-- Ovdje hvata $emit koji se desava unutar ItemForm; @ je isto kao v-on: -->
      </div>
    </div>
  </q-page>
</template>

<script>
import CategoryTable from 'src/components/Category/CategoryTable.vue'
import CategoryForm from 'src/components/Category/CategoryForm.vue'

export default {
  components: {
    CategoryTable,
    CategoryForm
  },
  name: 'PageItems',
  data () {
    return {
      tableKey: 0
    }
  },
  methods: {
    afterCateogorySubmit () {
      this.tableKey++
    }
  }
}
</script>

<style lang="scss">
  @media (max-width: 550px) {
    .offset-bit {
      margin-left: -70px;
    }
  }

  @media (max-width: 375px) {
    .offset-bit {
      margin-left: -105px;
    }
  }
</style>
