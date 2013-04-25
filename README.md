NebulaGridWrapper
=================
NebulaGridWrapper helps to represent list of objects used by Nebula Grid.

You have to write how to represent the object in the table row:
<pre>
    public static class SimpleNodeFactory extends NodeFactory {

        @Override
        public void setNodeData(Node node, final Object object) {
            Map<String, CellProperty> values = new HashMap<String, CellProperty>();
            values.put("name", new CellProperty(((PeopleDTO) object).getName()));
            values.put("age", new CellProperty(((PeopleDTO) object).getAge()));
            node.setCellPropertiesMap(values);
        }
    }
</pre>

and create Grid:
<pre>
        List<IColumn> columnsList = ColumnsFactory.createColumns(new String[] {"name", "age"});
        GridTable grid = new GridTable(shell, GridTable.DEFAULT_STYLE, new SimpleNodeFactory(), columnsList);
</pre>

After that you can simply add data to the grid:
<pre>
        grid.setData(DataProvider.getPeople());
</pre>

Supported features:

1. Color and font of columns and cells
2. Tooltips
3. Click and selection listeners
4. Single- and multiselect rows
5. Editors in cells
6. Images in cells
