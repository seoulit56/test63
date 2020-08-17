<template>
    
  <span>{{ minutes }} :  {{ seconds }}</span>

</template>

<script>
import EventBus from '@/util/eventbus' 
export default {
  props: {
    ccnTime: Number
  },
  mounted() {
    EventBus.$off('ccn-time');
    EventBus.$on('ccn-time', (state) => {
      if(state === 'start') {
        clearInterval(this.timer)
        this.timer = null
        this.totalTime = this.ccnTime
        this.startTimer()
      } else {
        this.stopTimer()  
      }
    })
  },    
  data: () => ({
        title: 'Timer',
        totalTime: null,
        timer: null
  }),
  methods: {
    startTimer: function() {
        this.timer = setInterval(() => this.countdown(), 1000);
    },
    stopTimer: function() {
        clearInterval(this.timer)
    },
    padTime: function(time) {
        return (time < 10 ? '0' : '') + time
    },
    countdown: function() {
        if(this.totalTime >= 1) {
            this.totalTime--
        } else {
            this.totalTime = 0;
            this.resetTimer
        }
    }
  },
  computed: {
      minutes: function() {
          const minutes = Math.floor(this.totalTime / 60)
          return this.padTime(minutes)
      },
      seconds: function() {
          const seconds = this.totalTime - (this.minutes * 60)
          return this.padTime(seconds)
      }
  }
}
</script>
