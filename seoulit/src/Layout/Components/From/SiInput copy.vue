
<template>
  <el-popover
   popperClass="error-pop"
   placement="bottom"
   trigger="manual"
   :content="validMsg" 
   v-model="valid">
   <div 
   class="el-input el-input--suffix"
   slot="reference">
    <input
     type="text"
     class="el-input__inner"
     :value='iValue'
     @input="$emit('update:iValue', $event.target.value)"
     :disabled="disabled" />
     <span class="el-input__suffix">
      <span class="el-input__suffix-inner">
       <i v-show="valid"
        class="el-icon-warning el-input__icon red-c"
       slot="suffix">
      </i>
      </span>
     </span>
    </div>
  </el-popover>
</template>

<script>
export default {
  props: {
    iValue: String,
    valid: Boolean,
    validMsg: String,
    disabled: Boolean
  },
  computed: {
    classObject: function() {
      return {
       'red-c': this.valid
      }
    }
  }
}
</script>