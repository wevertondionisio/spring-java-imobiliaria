$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget);
	var codigoTitulo = button.data('id');
	var descricaoTitulo = button.data('categoria');
	
	var modal = $('#confirmacaoExclusaoModal');
	var form = modal.find('form');
	var action = form.data('url-base');
	
	if (!action.endsWith('/')) {
		action += '/';
	}
	
	form.attr('action', action + codigoTitulo);
	modal.find('.modal-body p').html('Tem certeza que deseja apagar <strong>' + descricaoTitulo + '<strong>?');
});