/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Homologação
 */
public enum EnumOrigem {
    
    NACIONAL1(1, "0 - Nacioanal, Exceto indicadas no 3 e 5"),
    ESTRANGEIRA2(2, "1 - Estrangeira, importação direta exceto 6"),
    ESTRANGEIRA3(3, "2 - Estrangeira adquirida no mercado interno exceto 7"),
    NACIONAL4 (4, "3 - Nacional com conteúdo importado acima de 40%"),
    NACIONAL5 (5, "4 - Nacional, cuja produção tenha sido feita em conformidade"
            + " com os processos produtivos básicos de que tratam o Decreto-Lei nº 288/67, e as Leis nºs 8.248/91, 8.387/91, 10.176/01 e 11 . 4 8 4 / 0 7"),
    NACIONAL6 (6, "5 - Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40%"),
    ESTRANGEIRA7 (7, "6 - Estrangeira - Importação direta, sem similar nacional, constante em lista de Resolução CAMEX"),
    ESTRANGEIRA8 (8, "7 - Estrangeira - Adquirida no mercado interno, sem similar nacional, constante em lista de Resolução CAMEX"),
    NACIONAL9 (9, "8 - Nacional com conteúdo importado acima de 70%");
        
    final String descricao;
    final int codigo;

    private EnumOrigem(int codigo, String descricao) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public EnumOrigem getEnumPorCodigo(int codigo) {
        for (EnumOrigem enumOrigem : EnumOrigem.values()) {
            if (enumOrigem.getCodigo() == codigo) {
                return enumOrigem;
            }
        }
        return null;
    }

    public String getDescricao() {
        return descricao;

    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
}
