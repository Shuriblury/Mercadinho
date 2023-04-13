
//ensinando a lista da tela como deve ser mostrado cada item
        ArrayAdapter<Pessoa> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pessoaController.getListaPessoasFiltro(false));
        listPessoa.setAdapter(adapter);

        //contexto da lista de itens
        registerForContextMenu(listPessoa);

        }

//fazendo o menu ser mostrado onde eu quero
//sobrescrever o método

@Override
public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_principal, menu);

        //manipular o botão buscar
        SearchView searchView = (SearchView) menu.findItem(R.id.buscarPessoa).getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
@Override
public boolean onQueryTextSubmit(String s) {
        return false;
        }

@Override
public boolean onQueryTextChange(String s) {
        pessoaController.procuraPessoaFiltro(s);
        listPessoa.invalidateViews();
        return false;
        }
        });
        return  true;
        }


//para tela de cadastro
public  void cadastrar(MenuItem menuItem){
        Intent intent = new Intent(ListaPessoaActivity.this, MainActivity.class);
        startActivity(intent);
        }

//para verificar o estado de ativo novamente da tela
//Resume
@Override
protected void onResume(){
        super.onResume();
        pessoaController.getListaPessoasFiltro(true).clear();
        pessoaController.getListaPessoasFiltro(true);
        listPessoa.invalidateViews();

        }

@Override
public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_contexto, menu);
        }

//para ensinar o botão excluir do menu de contexto
public void excluir(MenuItem menuItem){
        //pegar a posição clicada
        AdapterView.AdapterContextMenuInfo menuInfo =
        (AdapterView.AdapterContextMenuInfo)
        menuItem.getMenuInfo();
final Pessoa pessoaParaApagar =
        pessoaController
        .getListaPessoasFiltro(false)
        .get(menuInfo.position);
        //dialogo com confirmação
        AlertDialog dialog = new AlertDialog
        .Builder(this)
        .setTitle("Atenção")
        .setMessage("Deseja realmente excluir?")
        .setNegativeButton("Não", null)
        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialogInterface, int i) {
        //removendo pessoa
        //remover a pessoa da lista
        pessoaController.removerPessoaDasListas(pessoaParaApagar);
        pessoaController.excluirPessoa(pessoaParaApagar);
        listPessoa.invalidateViews();
        }
        })
        .create();
        dialog.show();









        }








        }