<template>
  <q-page class="flex flex-center">
    <div class="row">
      <div class="col-6">
        <item-table :key="tableKey" />
      </div>
      <div class="col-5 offset-1" style="margin-top:150px">
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
