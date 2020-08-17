<template>
  <el-form-item class="no-margin-b">
    <template slot="label">
      <span :class="classObject">   
        {{label}} <span class="red-c">*</span>
      </span>
    </template>
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
       v-on:blur="validating"
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
  </el-form-item>
</template>

<script>
export default {
  props: {
    iValue: String,
    label: String,
    valid: Boolean,
    validMsg: String,
    disabled: Boolean,
    validating: Function
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