package entity;

/**
 *
 * @author Homologação
 */
public enum EnumTipoEndereco {
        
    COMERCIAL(1, "Comercial"),
    RESIDENCIAL(2, "Residencial"),
    OUTROS(3, "Outros");
        
    final String descricao;
    final int codigo;

    private EnumTipoEndereco(int codigo, String descricao) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public EnumTipoEndereco getEnumPorCodigo(int codigo) {
        for (EnumTipoEndereco enumDiaSemana : EnumTipoEndereco.values()) {
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

