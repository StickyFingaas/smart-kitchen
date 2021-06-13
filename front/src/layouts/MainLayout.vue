<template>
  <q-layout view="hHr lpR fFr">
    <q-header elevated>
      <q-toolbar>
        <q-btn
          flat
          dense
          round
          icon="menu"
          aria-label="Menu"
          @click="leftDrawerOpen = !leftDrawerOpen"
        />

        <q-toolbar-title>
          Smart Kitchen
        </q-toolbar-title>

        <div>In progress</div>
      </q-toolbar>
    </q-header>

    <q-drawer
      v-model="leftDrawerOpen"
      bordered
      content-class="bg-grey-1"
    >
      <q-list>
        <q-item-label
          header
          class="text-grey-8"
        >
          Essential Links
        </q-item-label>
        <EssentialLink
          v-for="link in essentialLinks"
          :key="link.title"
          v-bind="link"
        />
      </q-list>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script>
import EssentialLink from 'components/EssentialLink.vue'

const linksData = [
  {
    title: 'Home',
    caption: 'Where Smart Kitchen is',
    icon: 'home',
    link: '/#/'
  },
  {
    title: 'Kitchen Users',
    caption: 'List of all kitchen users',
    icon: 'person',
    link: '/#/user'
  },
  {
    title: 'Items',
    caption: 'List of all available items',
    icon: 'receipt',
    link: '/#/item'
  },
  {
    title: 'Github',
    caption: 'github.com/quasarframework',
    icon: 'code',
    link: 'https://github.com/quasarframework'
  }// ,
  // {
  //   title: 'Recipe',
  //   caption: 'Here you can see all recipes!',
  //   icon: 'add',
  //   link: '/#/recipe'
  // }
]

export default {
  name: 'MainLayout',
  components: { EssentialLink },
  data () {
    return {
      leftDrawerOpen: false,
      essentialLinks: linksData
    }
  }
}
</script>
