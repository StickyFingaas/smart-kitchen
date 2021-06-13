<template>
    <div>
        <p>Kitchen Items</p>
        <div class="row">
            <q-table>
                <tr>
                    <td>ojsa</td>
                </tr>
            </q-table>
        </div>
    </div>
</template>

<script>
// import Vue from 'vue'
// Importovanje servisa umjesto cumbersome Vuea i stalnog rada sa njim, sve definisano u servisu
import ItemService from '../../services/rest-services/item.service.js'
export default {
  data () {
    return {
      // path: 'getAllKitchenUsers',
      items: []
    }
  },
  // async/await varijanta slanja http zahtjeva kad god ocekujemo neku povratnu informaciju sa servera za npr. prikaz ili proracun
  // , veoma dobro za nauciti
  async created () {
    const response = await ItemService.getAllItems()
    console.log(response)
    this.items = response.data // Cilja listu koja se nalazi u data()
  },
  methods: {

  }
}
</script>

<style lang="scss">

</style>
