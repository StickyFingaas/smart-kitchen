<template>
  <q-page class="row justify-center content-center">
    <div class="row justify-center items-baseline col-8 q-gutter-xl">
      <div class="col-auto">
        <item-table :key="tableKey" />
      </div>
      <div class="col-4">
        <item-form @onItemSubmit="afterItemSubmit()" /> <!-- Ovdje hvata $emit koji se desava unutar ItemForm; @ je isto kao v-on: -->
      </div>
    </div>
  </q-page>
</template>

<script>
import ItemTable from 'src/components/Item/ItemTable.vue'
import ItemForm from 'src/components/Item/ItemForm.vue'

export default {
  components: {
    ItemTable,
    ItemForm
  },
  name: 'PageItems',
  data () {
    return {
      tableKey: 0
    }
  },
  methods: {
    afterItemSubmit () {
      this.tableKey++
    }
  }
}
</script>

<style lang="scss">

</style>
