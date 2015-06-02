package entity;

/**
 *
 * @author Homologação
 */
public enum EnumTipoFone {
    
    CELULAR(1, "Celular"),
    COMERCIAL(2, "Comercial"),
    CONTATO(3, "Contato"),
    FAX(4, "Fax"),
    PAGER(5, "Pager"),
    RESIDENCIAL(6, "Residencial"),
    OUTROS(7, "Outros");
    
    final String descricao;
    final int codigo;

    private EnumTipoFone(int codigo, String descricao) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public EnumTipoFone getEnumPorCodigo(int codigo) {
        for (EnumTipoFone enumDiaSemana : EnumTipoFone.values()) {
            if (enumDiaSemana.getCodigo() == codigo) {
                return enumDiaSemana;
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

