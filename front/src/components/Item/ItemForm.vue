<template>
    <q-form @submit="onSubmit" class="q-gutter-md">
        <div class="col">
            <q-input v-model="item.name" type="text" label="Name" outlined lazy-rules class="gib-padding"/>
            <q-input
                class="q-nt-nd gib-padding"
                v-model="item.price"
                type="text"
                label="Price"
                outlined
            />
            <q-input
                class="q-nt-nd gib-padding"
                v-model="item.condition"
                type="text"
                label="Condition"
                outlined
            />
        </div>
        <div>
            <q-btn label="Submit" type="submit" color="accent"/>
        </div>
    </q-form>
</template>

<script>
// import Vue from 'vue'
// Ista stvar sa importom da se ne mora peglati oko rada sa Vue objektom
import ItemService from '../../services/rest-services/item.service.js'

export default {
  data () {
    return {
      path: 'createItem',
      item: {
        name: null,
        price: null,
        condition: null
      }
    }
  },
  methods: {
    onSubmit () {
      // callback varijanta slanja http zahtjeva
      ItemService.createItem(this.item).then(response => {
        if (response.status === 200) {
          this.postSubmit()
          this.resetItem()
        } else {
          console.log('Error')
          console.log(response)
        }
      })
        .catch(err => {
          console.log(err)
        })
    },
    postSubmit () {
      this.$emit('onItemSubmit') // Vue ugradjena metoda za emitovanje objekta koji onda glavni page moze da uhvati
    },
    // Resetuje formu nakon submita
    resetItem () {
      this.item = {
        name: null,
        price: null,
        condition: null
      }
    }
  }
}
</script>

<style scoped lang="scss">
  .col {
    min-width: 200px;
  }

  .gib-padding {
    padding-bottom: 5px;
  }
</style>
