<script type="text/x-template" id="search-common">
    <!-- BEGIN # MODAL LOGIN -->
    <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- Begin # DIV Form -->
                <div id="div-forms">
                    <form id="login-form">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span class="flaticon-add" aria-hidden="true"></span>
                        </button>
                        <div class="modal-body">
                            <input class="form-control" type="text" placeholder="What you are looking for?" required>
                        </div>
                    </form><!-- End # Login Form -->
                </div><!-- End # DIV Form -->
            </div>
        </div>
    </div>
    <!-- END # MODAL LOGIN -->

</script>

<script type="text/javascript">
    Vue.component('search-common', {
        template: '#search-common',
        data: function () {
            return {
                firstName1: '龙',
                lastName1: '阿发',
                alias1: '打发'
            }
        },
        computed: {},
        methods: {},
        watch: {},
        created: function () {
            var self = this;

        },
        mounted: function () {

        }
    });
</script>