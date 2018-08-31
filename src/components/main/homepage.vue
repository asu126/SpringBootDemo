<template>
  <div id="app">
    <Carousel/>
    <News/>
  </div>
</template>

<script>
import Carousel from './carousel'
import News from './News'

export default {
  components: { Carousel, News }
}
</script>
