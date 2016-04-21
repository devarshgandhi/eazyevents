module.exports = function(grunt) {

  grunt.initConfig({
        serve: {
        options: {
            port: 9000
        }
    },
    pkg: grunt.file.readJSON('package.json'),
    jshint: {
      files: ['Gruntfile.js', 'script/**/*.js', 'test/**/*.js'],
      options: {
        // options here to override JSHint defaults
        globals: {
          jQuery: true,
          console: true,
          module: true,
          document: true
        }
      }
    },
    watch: {
      files: ['<%= jshint.files %>'],
      tasks: ['jshint']
    }
  });
grunt.loadNpmTasks('grunt-serve');
  //grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-contrib-jshint');

  //grunt.registerTask('test', ['jshint', 'qunit']);

  grunt.registerTask('default', ['jshint']);

};