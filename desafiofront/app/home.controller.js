(function () {
    "use strict";

    angular.module('autoLocadoraApp')
        .controller('HomeController', homeController);

    homeController.$inject = ['helperFactory', 'autoLocadoraService'];

    function homeController(helper, service) {
        var vm = this;
        /* ***************    INIT VARIÁVEIS    *********************************** */

        /* ***************    FUNÇÕES EXECUTADAS NA VIEW (HMTL)    **************** */
        vm.go = helper.go;
        vm.iniciar = iniciar;
        vm.submit = submit;

        function iniciar() {
            return vm.listarCarros();
        }

        /* ***************    FUNÇÕES ADD 'VM' PARA TESTES     **************** */
        vm.listarCarros = listarCarros;

        function submit() {
            if (vm.cliente._id) {
                return editar();
            } else {
                return cadastrar();
            }
        }

        /* ***************    FUNÇÕES INSTERNAS    ******************************** */
        function listarCarros() {
            return service.listar()
                .then(function (_listaCarros) {
                    vm.listaCarros = _listaCarros;
                    helper.rootScopeApply();
                });
        }

        function cadastrar() {
            return service.cadastrar(vm.cliente)
                .then(function (_cliente) {
                    tratarResposta('cadastrado', _cliente);
                });
        }


    }

})();