# A3 PROGRAMAÇÃO DE SOLUÇÕES COMPUTACIONAIS 

Entrega do código do trabalho A3, da UC de programação de soluções computacionais.
O objetivo deste programa é facilitar a realização de doações, cadastrando Ongs e usuarios, tendo um envio de mensagem entre os mesmos. 

Link do video de apresentação: https://www.youtube.com/watch?v=RwRuPi0HK9I

Segue a base de dados de nosso programa.

-- Banco de dados: `youneedy`

-- Estrutura para tabela `login`

CREATE TABLE `login` (
  `cd_login` int(11) NOT NULL,
  `email_login` varchar(30) NOT NULL,
  `senha_login` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `login`
--

INSERT INTO `login` (`cd_login`, `email_login`, `senha_login`) VALUES
(1, 'samuel', '1234'),
(2, 'pedro', '123'),
(3, 'samuel123.gmail', '234');

-- --------------------------------------------------------

--
-- Estrutura para tabela `mensagem`
--

CREATE TABLE `mensagem` (
  `cd_msg` int(11) NOT NULL,
  `msg_texto` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `mensagem`
--

INSERT INTO `mensagem` (`cd_msg`, `msg_texto`) VALUES
(1, 'boa noite, quero fazer uma doação'),
(2, 'olá, estou com duvidas sobre a doação...'),
(3, 'Boa noite, estou com duvidas sobre as doações ');

-- --------------------------------------------------------

--
-- Estrutura para tabela `ong`
--

CREATE TABLE `ong` (
  `cd_ong` int(11) NOT NULL,
  `email_ong` varchar(30) NOT NULL,
  `nome_ong` varchar(40) NOT NULL,
  `nome_resp` varchar(40) NOT NULL,
  `endereço_ong` varchar(40) NOT NULL,
  `senha_ong` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `ong`
--

INSERT INTO `ong` (`cd_ong`, `email_ong`, `nome_ong`, `nome_resp`, `endereço_ong`, `senha_ong`) VALUES
(2, '', '', '', '', ''),
(3, 'sementes123.gmail', 'Sementes do bem', 'João', 'Rua 9', '234'),
(4, 'anjosajudam.gmail', 'Anjos da ajuda', 'Carla', 'Rua das flores ', '567'),
(5, 'salva456.gmail', 'Salvação', 'Fernando', 'Rua Brasil', '123');

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuario`
--

CREATE TABLE `usuario` (
  `cd_usuario` int(11) NOT NULL,
  `email_usuario` varchar(30) NOT NULL,
  `senha_usuario` varchar(10) NOT NULL,
  `nome_usuario` varchar(40) NOT NULL,
  `endereço_usuario` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `usuario`
--

INSERT INTO `usuario` (`cd_usuario`, `email_usuario`, `senha_usuario`, `nome_usuario`, `endereço_usuario`) VALUES
(2, 'd', 'f', 'd', 'd'),
(3, '', '', '', ''),
(4, 'renan123', '2334', 'renan', 'casa1'),
(6, 'arlete.gmail', '567', 'Arlete', 'casa40'),
(7, 'carlinhos.gmail', '673', 'Carlos', 'rua linda '),
(8, '', '', '', ''),
(9, 'samuel123.gmail', '234', 'samuel', 'rua 38');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`cd_login`);

--
-- Índices de tabela `mensagem`
--
ALTER TABLE `mensagem`
  ADD PRIMARY KEY (`cd_msg`);

--
-- Índices de tabela `ong`
--
ALTER TABLE `ong`
  ADD PRIMARY KEY (`cd_ong`);

--
-- Índices de tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`cd_usuario`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `login`
--
ALTER TABLE `login`
  MODIFY `cd_login` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `mensagem`
--
ALTER TABLE `mensagem`
  MODIFY `cd_msg` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `ong`
--
ALTER TABLE `ong`
  MODIFY `cd_ong` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `cd_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;


